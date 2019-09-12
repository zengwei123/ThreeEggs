package com.example.z_common.Util;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import com.example.z_base.BaseActivity;
import com.example.z_common.Custom.Dialog.DialogUtil;
import com.example.z_common.R;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import java.io.File;
import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

/**下载工具**/
public class DownloadUtil {
    private static DownloadManager downloadManager;
    private static RxTimerUtil rxTimerUtil;
    private static long id;
    /**提示更新 调用系统下载**/
    public static void isUpdate(final String url){
        new DialogUtil().show(R.mipmap.prompt,"发现新版本，是否现在更新","更新", new DialogUtil.DialogButtonListener(){
            @Override
            public void sure() {
                SimpleUtils.setToast("开始更新");
                //创建下载任务,downloadUrl就是下载链接
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                //指定下载路径和下载文件名
                request.setDestinationInExternalPublicDir("/Download/", "zw.apk");
                //获取下载管理器
                downloadManager= (DownloadManager) BaseActivity.getInstance().getSystemService(Context.DOWNLOAD_SERVICE);
                //将下载任务加入下载队列，否则不会进行下载
                id= downloadManager.enqueue(request);
                //定时查询下载的进度
                rxTimerUtil=new RxTimerUtil();
                rxTimerUtil.interval(1000, new RxTimerUtil.RxAction() {
                    @Override
                    public void action(long number) {
                        TimeSelectDownload(downloadManager,id);
                    }
                });
            }

            @Override
            public void cancel() {

            }
        });
    }

    private static void TimeSelectDownload( DownloadManager downloadManager ,long id){
        // 创建一个查询对象
        DownloadManager.Query query = new DownloadManager.Query();
        // 根据 下载ID 过滤结果
        query.setFilterById(id);
        // 执行查询, 返回一个 Cursor (相当于查询数据库)
        Cursor cursor = downloadManager.query(query);

        if (!cursor.moveToFirst()) {
            cursor.close();
            return;
        }
        // 下载ID
        long ids = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_ID));
        // 下载请求的状态
        int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
        // 下载文件在本地保存的路径（Android 7.0 以后 COLUMN_LOCAL_FILENAME 字段被弃用, 需要用 COLUMN_LOCAL_URI 字段来获取本地文件路径的 Uri）
        String localFilename;
        localFilename= cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
        // 已下载的字节大小
        long downloadedSoFar = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
        // 下载文件的总字节大小
        long totalSize = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
        cursor.close();
//        SimpleUtils.setLog("zwccc下载进度: " + downloadedSoFar  + "/" + totalSize);
        /*
         * 判断是否下载成功，其中状态 status 的值有 5 种:
         *     DownloadManager.STATUS_SUCCESSFUL:   下载成功
         *     DownloadManager.STATUS_FAILED:       下载失败
         *     DownloadManager.STATUS_PENDING:      等待下载
         *     DownloadManager.STATUS_RUNNING:      正在下载
         *     DownloadManager.STATUS_PAUSED:       下载暂停
         */
        if (status == DownloadManager.STATUS_SUCCESSFUL) {
            /*
             * 特别注意: 查询获取到的 localFilename 才是下载文件真正的保存路径，在创建
             * 请求时设置的保存路径不一定是最终的保存路径，因为当设置的路径已是存在的文件时，
             * 下载器会自动重命名保存路径，例如: .../demo-1.apk, .../demo-2.apk
             */
            String[] strings=localFilename.split("/");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                qx(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getAbsolutePath()+"/"+strings[strings.length-1]);

            }else {
                install(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getAbsolutePath()+"/"+strings[strings.length-1]);
            }
            rxTimerUtil.cancel();
        }else if (status == DownloadManager.STATUS_FAILED){
            SimpleUtils.setToast("zwccc下载失败");
        }
    }

    private static void qx(final String s){
        XXPermissions.with(BaseActivity.getInstance())
                .permission(Permission. REQUEST_INSTALL_PACKAGES) //支持请求6.0悬浮窗权限8.0请求安装权限
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        if (!isAll){
                            DialogUtil dialogUtil = new DialogUtil();
                            dialogUtil.show(R.mipmap.prompt, "需要权限才能打开下载的apk安装包", "设置",new DialogUtil.DialogButtonListener() {
                                @Override
                                public void sure() {
                                    XXPermissions.gotoPermissionSettings(BaseActivity.getInstance());
                                }

                                @Override
                                public void cancel() {
                                }
                            });
                        }else {
                            install(s);
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {

                    }
                });
    }



    /**apk安装**/
    private static void install(String path) {
        try {
            File apkFile = new File(path);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //  mvpView.getVersionActivity().showToast("版本大于 N ，开始使用 fileProvider 进行安装");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(BaseActivity.getInstance(), "com.example.zengwei.threeeggs.fileprovider", apkFile);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            }
            BaseActivity.getInstance().startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

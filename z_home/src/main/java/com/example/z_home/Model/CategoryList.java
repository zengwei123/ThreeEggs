package com.example.z_home.Model;

import java.util.List;

public class CategoryList {

    private List<ItemCategoriesBeanX> itemCategories;
    public List<ItemCategoriesBeanX> getItemCategories() {
        return itemCategories;
    }
    public void setItemCategories(List<ItemCategoriesBeanX> itemCategories) {
        this.itemCategories = itemCategories;
    }

    public static class ItemCategoriesBeanX {
        /**
         * id : 1
         * parentId : 0
         * name : 男装
         * typeTemplateId : 35
         * itemCategories : [{"id":8,"parentId":1,"name":"男装1"},{"id":9,"parentId":1,"name":"男装2"},{"id":10,"parentId":1,"name":"男装3"}]
         */

        private int id;   //分类的自动
        private int parentId;    //
        private String name;     //父类名字
        private List<ItemCategoriesBean> itemCategories;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public List<ItemCategoriesBean> getItemCategories() {
            return itemCategories;
        }

        public void setItemCategories(List<ItemCategoriesBean> itemCategories) {
            this.itemCategories = itemCategories;
        }

        public static class ItemCategoriesBean {
            /**
             * id : 8
             * parentId : 1
             * name : 男装1
             */

            private int id;
            private int parentId;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}

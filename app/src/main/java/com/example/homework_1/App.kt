package com.example.homework_1

class App {

    companion object {
        private  val list : ArrayList<String> = ArrayList()

        fun addList(name: String) {
            list.add(name)
        }

        fun getList(): ArrayList<String> {
            return list
        }
    }

}
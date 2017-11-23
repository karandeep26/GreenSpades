package com.proj.greenspades

/**
 * Created by karan on 23/11/17.
 */
class Data(var kpis:ArrayList<Kpis>,var transactions:ArrayList<Transactions>) {
    class Kpis(var text1:String,var value:Int)
    class Transactions(var _id:Int,var amountPaid:Int,var createdDate:String,var transactionDate:String,var customer:Customer)
    class Customer(var customerId:Int,var mobileNumber:String,var name:String)
}
package com.task.factorial

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bender on 24.09.17.
  */
class Calculator {
  def factorial(number: Int): BigInt = {
    val list = if (number == 0 )
      List(BigInt(1))
    else
      (BigInt(1) to number).toList
    val conf = new SparkConf().setAppName("Calculator")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(list)
    rdd.reduce(_ * _)
  }
}

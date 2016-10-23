package com.spark.demo1

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

/**
 * @author ${user.name}
 */
object App {
  
  def main(args : Array[String]) {
    val logFile = "/usr/local/spark/spark-1.3.1-bin-hadoop2.6/README.md"    /**???spark????**/
    val conf = new SparkConf().setAppName("App")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile,2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()

    println("Lines with a: %s,Lines with b: %s".format(numAs,numBs))

  }

}
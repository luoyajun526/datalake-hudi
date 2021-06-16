package com.datalake.common.runner

import org.apache.spark.sql.SparkSession

trait SparkRunner {

  private lazy val builder = SparkSession.builder()
    .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    .appName(getAppName())

  if (isLocal()) builder.master("local[2]")

  private lazy val spark = builder.getOrCreate()

  def isLocal(): Boolean

  def getAppName(): String

  def getSpark(): SparkSession = spark
}

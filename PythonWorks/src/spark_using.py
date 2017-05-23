import findspark

findspark.init()

# Or the following command
findspark.init("C:\\soft\\spark-2.1.1-bin-hadoop2.7\\spark-2.1.1-bin-hadoop2.7")

from pyspark import SparkConf, SparkContext
from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("PythonKMeans").getOrCreate()
lines = spark.textFile(self)
counter = lines.count()
print(counter)

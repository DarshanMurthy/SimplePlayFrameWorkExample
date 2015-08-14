import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint


object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "/Users/dtumkursreeni/Desktop/Test.pdf" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("!Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    println("Darshan Tumkur Sreenivasamurthy!")

	    // Load and parse the data file. and data set input is to be given here!
	val data = MLUtils.loadLibSVMFile(sc, "  ")
	// Split the data into training and test sets (30% held out for testing)
	val splits = data.randomSplit(Array(0.7, 0.3))
	val (trainingData, testData) = (splits(0), splits(1))

	// Train a DecisionTree model.
	//  Empty categoricalFeaturesInfo indicates all features are continuous.
	val numClasses = 2
	val categoricalFeaturesInfo = Map[Int, Int]()
	val impurity = "gini"
	val maxDepth = 5
	val maxBins = 32

	val model = DecisionTree.trainClassifier(trainingData, numClasses, categoricalFeaturesInfo,
	  impurity, maxDepth, maxBins)

	// Evaluate model on test instances and compute test error
	val labelAndPreds = testData.map { point =>
	  val prediction = model.predict(point.features)
	  (point.label, prediction)
	}
	val testErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / testData.count()
	println("Test Error = " + testErr)
	//println("Learned classification tree model:\n" + model.toDebugString)

	// Save and load model
	 //model.save(sc, "myModelPath")
	 //val sameModel = DecisionTreeModel.load(sc, "myModelPath")


  }
}

package cc.churrasco.spark.test;

import cc.churrasco.spark.test.controller.SparkController;

public class Application
{
	private static SparkController controller;

	public static void main(String[] args)
	{
		controller = new SparkController();
		controller.init();

		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			public void run()
			{
				System.out.println("Se esta apagando el server, vite");
				controller.shutDown();
			}
		});
	}
}
import java.util.concurrent.ThreadLocalRandom;

public class Driver {
    public static void driverFunction() {
        long startTime;
        long endTime;
        long durationTime;

        System.out.println("\n\n *********************************************************************************************************************** ");
        System.out.println("\n\n ------------------- ADD VERTEX AND EDGES MAY TAKE SOME TIME PLEASE DON'T STOP THE PROGRAM UNTIL END ------------------- ");
        System.out.println("\n\n *********************************************************************************************************************** ");

        System.out.println("\n\n ------------------- ADD EDGE AND VERTICES (UNDIRECTED) ------------------- ");

        System.out.println("\nCreate 100 Vertex size Graph undirected");

        MyGraph mg100 = new MyGraph(false, 100);

        System.out.println("Create and add 100 Vertex to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            mg100.addVertex(new Vertex(i, "label"));
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 100 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("Create and add 100 Edge to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i <= 99; i++) {
            mg100.addEdge(i, i + 1, (i+3)*2);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 100 Edge to Graph = " + durationTime + " milisecond \n");

        System.out.println("\nCreate 1000 Vertex size Graph undirected");

        MyGraph mg1000 = new MyGraph(false, 1000);

        System.out.println("Create and add 1000 Vertex to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            mg1000.addVertex(new Vertex(i, "label"));
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 1000 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("Create and add 1000 Edge to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i <= 999; i++) {
            mg1000.addEdge(i, i + 1, 0.0);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 1000 Edge to Graph = " + durationTime + " milisecond \n");

        System.out.println("\nCreate 10000 Vertex size Graph undirected");

        MyGraph mg10000 = new MyGraph(false, 10000);

        System.out.println("Create and add 10000 Vertex to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            mg10000.addVertex(new Vertex(i, "label"));
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 10000 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("Create and add 10000 Edge to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i <= 9999; i++) {
            mg10000.addEdge(i, i + 1, 0.0);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 10000 Edge to Graph = " + durationTime + " milisecond \n");

        System.out.println("\n\n ------------------- ADD EDGE AND VERTICES (DIRECTED) ------------------- ");

        System.out.println("\nCreate 100 Vertex size Graph directed");

        MyGraph mg100Directed = new MyGraph(true, 100);

        System.out.println("Create and add 100 Vertex to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            mg100Directed.addVertex(new Vertex(i, "label"));
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 100 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("Create and add 100 Edge to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i <= 99; i++) {
            mg100Directed.addEdge(i, i + 1, 0.0);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 100 Edge to Graph = " + durationTime + " milisecond \n");

        System.out.println("\nCreate 1000 Vertex size Graph directed");

        MyGraph mg1000Directed = new MyGraph(true, 1000);

        System.out.println("Create and add 1000 Vertex to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            mg1000Directed.addVertex(new Vertex(i, "label"));
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 1000 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("Create and add 1000 Edge to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i <= 999; i++) {
            mg1000Directed.addEdge(i, i + 1, 0.0);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 1000 Edge to Graph = " + durationTime + " milisecond \n");

        System.out.println("\nCreate 1000 Vertex size Graph directed");

        MyGraph mg10000Directed = new MyGraph(true, 10000);

        System.out.println("Create and add 10000 Vertex to Graph  ");
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            mg10000Directed.addVertex(new Vertex(i, "label"));
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 10000 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("Create and add 10000 Edge to Graph ");
        startTime = System.nanoTime();
        for (int i = 0; i <= 9999; i++) {
            mg10000Directed.addEdge(i, i + 1, 0.0);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Create and add 10000 Edge to Graph = " + durationTime + " milisecond \n");

        System.out.println("\n\n ------------------- FILTER VERTICES, PRINT GRAPH AND EXPORT MATRIX ------------------- ");

        System.out.println("\nSet properties to 100 Vertex and filter between 45-60 and print graph");
        startTime = System.nanoTime();
        for (Vertex vertex : mg100.getVertexes()) {
            if (vertex.getIndex() < 45 )
                vertex.setProperties("color", "red");
            else if (vertex.getIndex() > 45 && vertex.getIndex() < 60)
                vertex.setProperties("color", "green");
            else
                vertex.setProperties("color", "blue");
        }


        MyGraph mg100Filtered = mg100.filterVertices("color", "green");
        mg100Filtered.printGraph();

        for (int i = 46; i <= 59; i++) {
            mg100Filtered.addEdge(i, ThreadLocalRandom.current().nextInt(46,59), (i+1)*2);
        }

        System.out.println("\n Export the matrix filtered \n");
        
        double[][] mg100FilteredExported = mg100Filtered.exportMatrix();
        mg100Filtered.print2D(mg100FilteredExported);

        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        
        System.out.println("\n Set properties to 100 Vertex and filter between 45-60, print graph and print export matrix duration time  = " + durationTime + " milisecond \n");

        System.out.println("\nRemove 1000/2 Vertex to Graph (If Vertex is deleting related edge is also deleting) ");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            mg1000Directed.removeVertex(i / 2);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Remove 1000/2 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("\nRemove 10000/2 Vertex to Graph (If Vertex is deleting related edge is also deleting) ");
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            mg10000Directed.removeVertex(i / 2);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 10000);
        System.out.println("Remove 10000/2 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("\n\n ------------------- REMOVE EDGE AND VERTICES ------------------- ");

        System.out.println("\nRemove 100/2 Vertex to Graph (If Vertex is deleting related edge is also deleting) ");
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            mg100Directed.removeVertex(i / +1);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Remove 100/2 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("\nRemove 1000/2 Vertex to Graph (If Vertex is deleting related edge is also deleting) ");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            mg1000Directed.removeVertex(i / 2);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 100000);
        System.out.println("Remove 1000/2 Vertex to Graph = " + durationTime + " milisecond \n");

        System.out.println("\nRemove 10000/2 Vertex to Graph (If Vertex is deleting related edge is also deleting) ");
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            mg10000Directed.removeVertex(i / 2);
        }
        endTime = System.nanoTime();
        durationTime = ((endTime - startTime) / 10000);
        System.out.println("Remove 10000/2 Vertex to Graph = " + durationTime + " milisecond \n");

        Vertex v0 = new Vertex(0, "Erzincan", 2.1);
        v0.setProperties("Boosting", "102");
        Vertex v1 = new Vertex(1, "Eskisehir", 10.76);
        v1.setProperties("Boosting", "110");
        Vertex v2 = new Vertex(2, "Bursa", 14.2);
        v2.setProperties("Boosting", "67");
        Vertex v3 = new Vertex(3, "Eskisehir", 12.5);
        v3.setProperties("Boosting", "84");
        Vertex v4 = new Vertex(4, "Eskisehir", 4.5);
        v4.setProperties("Boosting", "45");
        Vertex v5 = new Vertex(5, "Istanbul", 2.7);
        v5.setProperties("Boosting", "78");

        MyGraph mgForSearches = new MyGraph(true, 10);

        mgForSearches.addVertex(v0);
        mgForSearches.addVertex(v1);
        mgForSearches.addVertex(v2);
        mgForSearches.addVertex(v3);
        mgForSearches.addVertex(v4);
        mgForSearches.addVertex(v5);

        mgForSearches.addEdge(0, 2, 200);
        mgForSearches.addEdge(2, 5, 70);
        mgForSearches.addEdge(2, 4, 502);
        mgForSearches.addEdge(1, 4, 531);
        mgForSearches.addEdge(0, 5, 132);
        mgForSearches.addEdge(3, 0, 747);
        mgForSearches.addEdge(3, 5, 101);

        long startTimeBST = System.nanoTime();
        double parent[][] = Search.breadthFirstSearch(mgForSearches, 0);
        long endTimeBST = System.nanoTime();

        long startTimeDST = System.nanoTime();
        double parent2[][] = Search.depthFirstSearch(mgForSearches);
        long endTimeDST = System.nanoTime();
        
        long durationTimeBST = ((endTimeBST - startTimeBST) / 10000);
        long durationTimeDST = ((endTimeDST - startTimeDST) / 10000);

        System.out.println("Diffirences between BST - DFS duration weight = " + (parent[0][5] - parent2[0][5]) + " milisecond \n");
        System.out.println("Diffirences between BST - DFS duration time = " + (durationTimeBST - durationTimeDST) + " milisecond \n");
        
        double[] pred = new double[mgForSearches.getNumberOfVertex()];
        int[] dist = new int[mgForSearches.getNumberOfVertex()];
        
        long startTimeDjikstra = System.nanoTime();
        pred = Search.dijkstasAlgorithm(mgForSearches, 0, dist, pred);
        long endTimeDjikstra = System.nanoTime();

        long durationTimeDjikstra = ((endTimeDjikstra - startTimeDjikstra) / 10000);

        System.out.println("Shortest path Djikstra with Booster = " + pred[5] + " \n");
        System.out.println("Duration time Djikstra with Booster = " + durationTimeDjikstra + " milisecond \n");


 


    }
}

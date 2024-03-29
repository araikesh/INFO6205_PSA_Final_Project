# INFO 6205 Spring 2023 Project Traveling Salesman Problem
## Name: ALTAF SALIM SHAIKH NUID: 002774748 
## Name: AVINASH RAIKESH NUID: 001090182

#### Aim:

The aim of this project is to implement and compare various op􀆟miza􀆟on methods, including tac􀆟cal methods such as random swapping, 2-opt and/or 3-opt improvement, and strategic methods such as simulated annealing, ant colony op􀆟miza􀆟on, gene􀆟c algorithms, etc., for solving the Traveling Salesman Problem (TSP). Specifically, we will implement the Christofides algorithm as a baseline, and compare its performance to the other methods in terms of solu􀆟on quality, computa􀆟on 􀆟me, and scalability.

####  Introduction:

The Traveling Salesman Problem (TSP) is a classic op􀆟miza􀆟on problem in computer science, which involves finding the shortest possible tour of 𝑛𝑛 ci􀆟es (or points in a two-dimensional space) that visits each city exactly once and returns to the star􀆟ng city. Despite its decep􀆟vely simple statement, the TSP is known to be an NP-hard problem, which means that it is computa􀆟onally infeasible to find an exact solu􀆟on for large problem instances. To address this challenge, researchers have developed a variety of heuris􀆟c and metaheuris􀆟c algorithms that can provide good approximate solu􀆟ons to the TSP in a reasonable amount of 􀆟me. In this project, we focus on comparing the performance of different op􀆟miza􀆟on methods for solving the TSP, with the goal of iden􀆟fying the most effec􀆟ve approaches for this challenging problem.

We begin by implemen􀆟ng the Christofides algorithm, which is a well-known heuris􀆟c algorithm for the TSP that guarantees a solu􀆟on within a factor of 3/2 of the op􀆟mal solu􀆟on. We then compare the performance of the Christofides algorithm to other op􀆟miza􀆟on methods, including tac􀆟cal methods such as random swapping, 2-opt and/or 3-opt improvement, and strategic methods such as simulated annealing, ant colony op􀆟miza􀆟on, gene􀆟c algorithms, etc. To evaluate the performance of these methods, we measure the quality of the solu􀆟ons they provide (i.e., how close they are to the op􀆟mal solu􀆟on), as well as their computa􀆟on 􀆟me and scalability. Our results provide insights into the strengths and limita􀆟ons of different op􀆟miza􀆟on methods for solving the TSP and may help inform the development of more effec􀆟ve approaches for this challenging problem.

####  Approach:

Our approach consists of implemen􀆟ng and comparing several op􀆟miza􀆟on methods for solving the Traveling Salesman Problem (TSP) and evalua􀆟ng their performance using a set of metrics. We use a Kaggle dataset with IDs, la􀆟tude and longitude values to test the aforemen􀆟oned techniques. From there, we u􀆟lized the Haversine formula to calculate the distance before u􀆟lizing the Prims algorithm to determine the MST Value and iden􀆟fy the odd ver􀆟ces. U􀆟lizing excellent Using a matching technique, we combine the edges to create the least value. The cycle is then found by u􀆟lizing the Euler graph and cycle, as well as the Hamiltonian cycle to eliminate unnecessary ver􀆟ces. Later in the tour, the topics of random swap, 2-opt, simulated annealing, and ant colony were covered. We discovered the ideal tour value with the aid of these algorithms. The correctness and performance of the so􀅌ware were demonstrated via graphical representa􀆟ons a􀅌er we assessed the program's output.
Optimization Methods.

We begin by implemen􀆟ng the Christofides algorithm as a baseline approach for solving the TSP. The Christofides algorithm is a well-known heuris􀆟c algorithm that provides a solu􀆟on within a factor of 3/2 of the op􀆟mal solu􀆟on. It involves construc􀆟ng a minimum spanning tree (MST) for the given set of ci􀆟es, and then finding a Eulerian circuit in the MST. Finally, Hamiltonian path algorithm is applied to the circuit to obtain a tour that visits each crime dataset scene exactly once. We then implement several other op􀆟miza􀆟on methods for solving the TSP, including tac􀆟cal methods such as random swapping, 2-opt, and strategic methods such as simulated annealing, ant colony op􀆟miza􀆟on. These methods are chosen based on their popularity and effec􀆟veness in the literature, and represent a diverse set of approaches to solving the TSP. 

#### Evaluation Metrics
To evaluate the performance of the op􀆟miza􀆟on methods, we use two main metrics:
Solution Quality: We measure the quality of the solu􀆟ons obtained by each method, by comparing them to the op􀆟mal solu􀆟on (when available) or to the best-known solu􀆟on in the literature. We use the rela􀆟ve error metric, which is defined as the ra􀆟o between the objec􀆟ve value of the obtained solu􀆟on and the op􀆟mal/best known solu􀆟on. Lower values of rela􀆟ve error indicate beter quality solu􀆟ons.
Computation Time: We measure the 􀆟me taken by each method to obtain a solu􀆟on, using a standard desktop computer with a fixed set of hardware specifica􀆟ons. We report the average computa􀆟on 􀆟me over several runs, to account for varia􀆟ons in performance due to random factors.

#### Program: Data Structures & classes – HashMaps, Lists, Custom classes (Edges,Vertex )

#### Algorithm –
Christofides: The Christofides algorithm is a heuristic algorithm that provides an approximate solution to the traveling salesman problem. It works by finding a minimum spanning tree and creating a subgraph of odd degree vertices. Then it finds a minimum weight perfect matching and combines the minimum spanning tree and the perfect matching that includes all vertices with an even degree. After that, it finds an Eulerian circuit (traversing each edge of the graph exactly once) and transforms it into a Hamiltonian circuit (traversing each vertex of the graph exactly once by skipping previously visited vertices). This algorithm guarantees that the solution will be at most 1.5 times the optimal solution,
with a time complexity of O(N^2log(N)) for a graph with N vertices. Random Swapping: This tactical optimization method involves removing two edges from the solution and reconnecting them in a different way to check if it results in a better solution. It can be more effective in improving the solution but is more computationally expensive than random swapping.
2-Opt: is a tactical optimization method that involves removing two edges from the solution and reconnecting them in a different way to check if it results in a better solution. It can be more effective in improving the solution but is more computationally expensive than random swapping.
Simulated Annealing is a metaheuristic algorithm for strategic optimization that is based on the annealing process in metallurgy. It starts with a high temperature and gradually cools down the system, allowing for more exploration at the beginning and more exploitation at the end. It can be useful in finding local optima, but careful parameter adjustment is necessary.
Ant Colony is a strategic optimization method that is based on the swarm intelligence of ants, who use pheromone trails to locate the shortest route between their nest and a food source. By laying virtual pheromone trails on the graph, the algorithm employs a similar method to determine the shortest path. It can be effective in finding good solutions quickly but requires careful tuning of its parameters and can get stuck in local optima.
Invariants: The graph must be undirected and connected. The minimum spanning tree must be connected. The subgraph of odd degree ver􀆟ces must have an even number of ver􀆟ces. The edges in the minimum weight perfect matching must connect odd degree ver􀆟ces. The combined graph must have even degree ver􀆟ces. The Eulerian circuit must start and end at the same vertex. Throughout the program, the edges produced by the primality methods used to calculate the Minimum Spanning Tree will have the same value. The data that is read from the dataset is moved to the list of type data that is used by the UI to iden􀆟fy the ver􀆟ces. Every tour is recorded in a separate list so that it may be used to determine the traversal cost and fed to other algorithms to get the most efficient value.

#### Conclusion 
In this report, we inves􀆟gated the effec􀆟veness of the Christofides algorithm and its op􀆟miza􀆟on methods in obtaining high-quality approximate solu􀆟ons to the traveling salesman problem. We used tac􀆟cal methods such as random swapping and 2-opt improvement, and strategic methods such as simulated annealing and ant colony op􀆟miza􀆟on. Based on our findings, the Christofides method produced high-quality approximate solu􀆟ons with a worst-case performance guarantee of 1.5 􀆟mes the op􀆟mal solu􀆟on. The addi􀆟on of op􀆟miza􀆟on methods such as random swapping and 2-opt improvement further improved the solu􀆟on quality. Simulated annealing and ant colony op􀆟miza􀆟on were also effec􀆟ve in improving the solu􀆟on quality but required careful parameter tuning. To ensure the program’s accuracy, we used object-oriented programming principles and unit tests to develop the Christofides algorithm and its op􀆟miza􀆟on methods in Java. We generated datasets of various sizes to test the performance and accuracy of the program. We discovered that the 2-opt improvement technique and the simulated annealing op􀆟miza􀆟on method provided significant improvements in solu􀆟on quality. This approach was able to escape from local op􀆟ma and enhance solu􀆟on quality while s􀆟ll allowing for sufficient explora􀆟on of the solu􀆟on space. In conclusion, our program implementa􀆟on in Java provides a prac􀆟cal tool for solving the problem, and future research should focus on op􀆟mizing methods and their combina􀆟on to achieve even beter results.

#### References 
htps://en.wikipedia.org/wiki/Christofides_algorithm
htps://en.wikipedia.org/wiki/Category:Travelling_salesman_problem
htps://www.youtube.com/watch?v=GiDsjIBOVoA&ab_channel=Reducible
htps://www.kaggle.com/datasets/marshuu/crimes-in-uk-2023?select=2023-01-metropolitan-street.csv
LearnbyExample. (2021, May 18). Solving the Travelling Salesman Problem using Ant Colony Op􀆟miza􀆟on [Video].
htps://www.youtube.com/watch?v=oXb2nC-e_EA&t=472s&ab_channel=LearnbyExample

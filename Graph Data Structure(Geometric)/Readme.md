Implemented a graph data structure in order to store the triangles, points and edges. A shape is produced from input triangles and different queries are answered regarding the shape produced.

For efficient implementation hashing is used for storing triangles as hashing promises expected Constant order time complexity for queries like search , get etc.

Queries like Maximum diameter of shape requires BFS(Breadth first search) of the graph, so BFS is implemented for this purpose using a queue. Queries like Centroid of shape requires DFS(Depth first search) of the graph , so DFS is implemented using stack.(Recursion is not used as recursion might causes Stack overflow for big inputs)

(Refer this link for more details:-http://web.iitd.ac.in/~csz188551/COL106_2019/assignment6/index.html)

A Student Database System.A student record contains a wealth of information about a student - her first name, last name, hostel, department, CGPA etc. The database is heavily loaded each year during a) the admission period when all the fresher students need to be added to the system, b) the grading period when the CGPAs of all the students need to be updated, and c) right after the convocation period when the graduating batch needs to be deleted from the system.



Since hash tables offer amortized expected constant time costs for insert, update and delete operations, they form a natural data structure choice for the above problem. This project implements the above database using a hash table keyed on the tuple (first name, last name), assuming it is unique to a student. The value corresponding to a key is an object containing all the other details about a student.


Each hash table implementation must deal with the problem of collisions. This project, compare two techniques for collision-resolution: 1) double-hashing, and 2) separate chaining using binary search trees. I have implemented both approaches and discover the impact of various design choices on the overall space and time complexity of all supported operations.


In the double-hashing approach, the hash table is visualised as an array of a pre-determined size based on an estimated maximum size of the dataset. If the estimated maximum size of the dataset is N then T = 1.5N is a reasonably good hash table size. To insert an object with a given key, the index for the key is calculated using a hash function h1. If the location corresponding to the resulting index is empty, the object is inserted at that location. Otherwise, i.e. in case of a collision, a fresh index is calculated using a different hash function h2. This process is repeated until an empty location is found. More precisely, at the i-th repetition of this process, the hash of a key k is given by h(k,i) = (h1(k) + i.h2(k)) mod T.


In the separate chaining approach also, the hash table is visualised as an array of a pre-determined size, but this size is independent of the maximum size of the dataset, and is usually much smaller. To insert an object, the index corresponding to the key is first calculated using the hash function h1. The resulting location contains a pointer to a different data structure, in this case the root of a binary search tree (BST), where all elements with the same index are stored. Since a BST requires that its nodes be comparable to each other, we need to define an order among the objects being stored in the BST. The key (first name, last name) is not comparable, since an object may be “bigger” than another by the first name but “smaller” by the last name. Therefore, we define the key for the BST to be the student’s first name, which is comparable by the alphabetical order.

INPUT DETAILS :- INPUT ARGUMENT is given as:-  SIZE APPROACH TEXT_FILE . E.G. :- java SDS 1 SCBST t.txt 
ANALYSIS.txt is also uploaded which gives the analysis of whole project like time complexity etc.

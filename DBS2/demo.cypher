//create nodes and relationships
CREATE (matei:Person {name:"Matei"})
CREATE (alex:Person {name:"Alex"})

CREATE (matei) - [:TEAMMATE {lecture:"Advanced database concepts"}] -> (alex)
CREATE (alex) - [:TEAMMATE {lecture:"Advanced database concepts"}] -> (matei)

CREATE (project:GROUP {number: 17})

CREATE (matei) - [:WORKS_ON] -> (project)
CREATE (alex) - [:WORKS_ON] -> (project)


//Updating

MATCH (alex {name: "Alex"}) - [paper:WORKS_ON] -> (:GROUP)
SET paper.work_hours = 100

//
MATCH (matei {name: "Matei"}) - [paper:WORKS_ON] -> (:GROUP)
SET paper.work_hours = 100

//
MATCH (alex {name: "Alex"})
SET alex.name = "Alex Constantinescu", alex.age = 21, alex.height = 180
RETURN alex

//
MATCH (matei {name: "Matei"})
SET matei.name = "Matei Grosu", matei.age = 20, matei.height = 180
RETURN matei

//Querying for nodes

MATCH (n) RETURN n

//All nodes with specific label 
MATCH (person:Person) 
RETURN person 
LIMIT 1

//Properies
MATCH (person:Person) 
RETURN person.name, person.height

//unique constraints
CREATE CONSTRAINT cons_name
FOR (person:Person)
REQUIRE person.name IS UNIQUE

//drop the constraint
DROP CONSTRAINT cons_name

//Deleting
//relationship
MATCH (alex {name: "Alex Constantinescu"}) - [rel:WORKS_ON] -> (:GROUP)
DELETE rel

//node
MATCH (matei {name: "Matei Grosu"})
DELETE matei

//node+rel
MATCH (matei {name: "Matei Grosu"})
DETACH DELETE matei

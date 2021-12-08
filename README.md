To compile the code mill reboot.compile To run the tests mill reboot.test To continually run the tests mill -w reboot.test

bicycle store / Jonne
car shop / Fredrik
flower shop / Matte
skapa modellen (case klasser) 
skapa saker i lager 
köpa saker 
saker söka på olika kriterier - pris - namn (case insensitive)

SERVER TEST TJOSAN

mill -w reboot.runBackground        

curl -XPOST http://localhost:8080/cycles -d '{"brand":"cresent", "price":300, "stock":22}'

curl -XGET http://localhost:8080/cycles 
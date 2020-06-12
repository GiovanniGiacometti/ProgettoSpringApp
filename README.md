# ProgettoSpringApp
Questo repository contiene il progetto svolto per l'esame di Programmazione ad Oggetti, anno accademico 2019/2020, del corso di laurea "Ingegneria Informatica e dell'Automazione" presso l'università Politecnica delle Marche.

## Introduzione al progetto
Il progetto consiste nella creazione, attraverso il framework Spring, di un'applicazione Java che sia in grado di consultare delle API esterne, modellarne i dati ottenuti in formato JSON e restituirli al client, sempre sotto forma di JSON, mediante richieste di tipo GET e POST.

Il nostro progetto, in particolare, lavora con le API di Twitter e l'obiettivo è quello di, dato un utente, analizzare il campo "location" dei suoi follower, attraverso opportuni filtri e statistiche.

Twitter è uno dei più famosi social network al mondo e si basa sull'interazione fra utenti. Ogni utente ha una lista di follower, ovvero di altri utenti che lo seguono, e una lista di amici, ovvero gli account da lui seguiti. Ogni utente è inoltre caratterizzato da una serie di parametri, tra cui la location.

La nostra applicazione, ad ogni chiamata, comunica con le API di twitter ed effettua il parsing dei follower di un utente secondo i parametri citati sopra, ovvero la location, il numero dei follower e il numero degli amici. Una volta avviata l'applicazione, è possbile filtrare i follower attraversi tali parametri e richiedere statistiche sulla location di tali follower.

## Funzionamento 

<img src = "Diagrammi%20UML/UML-%20Use%20Case%20diagram.jpg" >

Dopo aver avviato l'applicazione, sarà possibile interrogarla attraverso un API testing, ad esempio POSTMAN, all'indirizzo http://localhost:8080.

Come rappresentato dal diagramma UML dei casi d'uso, l'applicazione fornisce 5 rotte diverse, 3 di tipo GET e 2 di tipo POST. 
In ogni richiesta possono essere inseriti dei parametri opzionali, quali "user", ovvero il nome dell'utente che si vuole esaminare, e "number", ovvero il numero di follower da analizzare. Qualora non venissero inseriti, vengono utilizzati i parametri di default, rispettivamente "efrontoni" e "20".

I filtri devono essere inseriti nel body della richiesta POST in formato JSON. 

Le statistiche che si vogliono visualizzare vanno infine inserite come parametri. Se non viene specificata alcuna statistica, vengono fornite tutte quelle disponibili. 

ROTTA  | TIPO | PARAMETRI | DESCRIZIONE
------------- | ------------- | ------------- | --------------
\follower\data  | GET  | user, number | restituisce i follower richiesti
\follower\metadata  | GET | / | restituisce i metadata del modello
\follower\filter | POST | user, number | restituisce i follower filtrati 
\follower\stats | GET | user,number,stats | restituisce le statistiche richieste sui follower 
\follower\filter\stats | POST |user,number,stats|  restituisce le statistiche richieste sui follower filtrati

### Filtri
Il filtro va inserito nel body della richiesta POST con la seguente sintassi: `{ "campo" : { "metodo" : parametro} }`.

I filtri possono essere effettuati su tre campi, ovvero location (Location) , numero di follower (numFollowers) e numero di amici  (numFriends). 

Il numero di follower e il numero di amici sono informazioni numeriche. Pertanto, si possono applicare i seguenti filtri, validi per entrambi:

* greater , che restituisce i follower il cui attributo sia maggiore del numero passato come parametro (es  "greater" : 10 ).
* lower , che restituisce i follower il cui attributo sia minore del numero passato come parametro (es  "lower" : 20 ).
* between, che restituisce i follower il cui attributo sia compreso tra i numeri passati come parametro(es "between" : [10,20] ).

La location è invece una stringa di caratteri. Si possono applicare gli stessi filtri riportati sopra, relativi però al numero di caratteri presenti. Oltre a questi, sono disponibili anche i seguenti filtri:

* word, che restituisce i follower nella cui location è presente la parola passata come parametro (es "word": "Ancona").
* fullLoc, che restituisce i follower la cui location è uguale alla stringa passata come parametro ( es "fullLoc" : "Marche, Ancona").

E' possibile effettuare più filtri contemporaneamente, anche sullo stesso campo.
La sintassi è la seguente: ` { "campo" : { "metodo" : parametro} , "campo" : { "metodo" : parametro} }`

Di seguito vi sono alcuni esempi di chiamate con filtri.

* [Filtro Singolo](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/Filtro%20singolo.png)
* [Filtro Doppio](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/Filtro%20doppio.png)
* [Filtro non corretto](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/FiltroNonCorretto.png)


### Statistiche
La nostra applicazione consente di effettuare statistiche sul campo "location", in particolare sul numero di caratteri presenti.
Le statistiche richieste vanno inserite come parametri e possono essere effettuate sia sull'intero dataset che su quello filtrato.

Data quindi una lista di follower, ognuno caratterizzato da una location, le statistiche disponibili sono le seguenti: 
* max, ovvero il numero massimo di caratteri presenti nella location 
* min, ovvero il numero minimo di caratteri presenti nella location
* media, ovvero la media del numero di caratteri presenti nella location
* devStd, ovvero la deviazione standard 
* var , ovvero la varianza

Prima di ogni chiamata, viene comunicato il numero di follower presi in considerazione (nel caso di filtraggio non sono predeterminati).

  
Di seguito, alcuni esempi di chiamate con statistiche.
* [Alcune statistiche, specificate come parametri](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/SomeStats.png)
* [Parametro stats vuoto, vengono eseguite tutte le statistiche](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/AllStats.png)
* [Statistiche richieste su un dataset filtrato](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/StatsWithFIlter.png)
* [Statistica non esistente, errore](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/StatsError.png)

## Sviluppo
### CLASSI

#### Package presenti: 
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Packages.jpg" height = 400>

#### giopollo.progetto.Controller :
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Controller.jpg" height = 300>

La classe Controller gestisce le richieste dell'utente ed eventuali eccezioni.

#### giopollo.progetto.Database :
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Database.jpg" height = 300 >

La classe Download si occupa di comunicare con l'API di twitter, ususfruendo della classe ApiParsing.

#### giopollo.progetto.Model :
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Model.jpg" height = 300>

La classe Follower rappresenta il modello su cui si basa il progetto. La classa Data effettua il parsing dei dati. La classe Metadata gestisce i metadata del progetto.

#### giopollo.progetto.Service :
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Service.jpg" height = 600>

La classe urlService gestisce l'URL cui indirizzarsi a seconda della richiesta effettuata dall'utente.

La classe StatsService gestisce le statistiche, invocando in modo ciclico i metodi della classe Request.Stats corrispondenti alle richieste dell'utente.

La classe FilterService gestisce la decodifica dei filtri. Ricevuto il JSON, itera su tutti i filtri istanziando le classi del package Request.Filter e richiamandone i metodi richiesti.

La classe PrincipalService, infine, amministra le richieste dirottandole sui rispettivi Service.

#### giopollo.progetto.Request.Filter :
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Request.Filter.jpg" width = 1000>

Questo package contiene le classi necessarie alla realizzazione dei filtri. Quando l'utente vuole effettuare un filtro su un parametro, l'applicazione instanzia la classe corrispondente (NumFriends, NumFollowers e Location) e ne richiama poi il metodo desiderato.

I metodi disponibili sono organizzati in due interfacce, una per i filtri di tipo numerico, l'altra per i filtri di tipo "stringa".

Inoltre è presente una classe astratta che contiene l'implementazione del filtro Between.

#### giopollo.progetto.Request.Stats :
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Request.Stats.jpg" height = 300>

La classe contiene i metodi necessari al calcolo delle statistiche. 

#### giopollo.progetto.Exception :
<img src ="Diagrammi%20UML/UML%20-%20Class%20Diagram/Exception.jpg" height = 400>

Questo package contiene le eccezioni personalizzate e la classe ExceptionError, che viene restituita al client sotto forma di JSON qualora si verifichi un'eccezione.

Tutte le eccezioni ereditano dalla classe astratta E_Project.

L'eccezione E_NoFollowerFound viene lanciata quando non vi sono follower che rispettano il filtro desiderato.

L'eccezione E_wordNotFound viene lanciata quando non ci sono follower nella cui location vi sia la parola richiesta.

L'eccezione E_IncorrectFilterMethod viene lanciata quando il metodo del filtro è vuoto.

L'eccezione E_Between viene lanciata quando i parametri del filtro Between non sono corretti.

Esempi di gestione delle eccezioni:

* [Nessun follower rispetta il filtro](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/NessunaParola.png)

* [Parola non trovata](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/NoWordFound.png)

* [Metodo del filtro vuoto](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/MetodoFiltroVuoto.png)

* [Parametri del filtro between non corretti](https://github.com/GiovanniGiacometti/ProgettoSpringApp/blob/master/progetto/Screen/ParametriBetweenNonCorretti.png)

### SEQUENZE
Di seguito riportiamo i diagrammi delle sequenze che dettagliano il funzionamento delle chiamate.

#### getData :
<img src ="Diagrammi%20UML/UML-Sequence%20Diagram/SpringBootApp-Sequence%20Diagram-getData.jpg" height = 400>

#### getMetadata :
<img src ="Diagrammi%20UML/UML-Sequence%20Diagram/getMetadata.jpg" height = 400>

#### getDataWithFilter :
<img src ="Diagrammi%20UML/UML-Sequence%20Diagram/getDataWithFilter.jpg" height = 400>

#### getStats :
<img src ="Diagrammi%20UML/UML-Sequence%20Diagram/getStats.jpg" height = 400>

#### getStatsWithFilter :
<img src ="Diagrammi%20UML/UML-Sequence%20Diagram/getStatsWithFilter.jpg" height = 400>

## Autori
* **Giovanni Giacometti** 
* **Lorenzo Pollonara** 

#### Suddivisione del lavoro :
Abbiamo pensato di dividere lo sviluppo del progetto in tre fasi. Nella prima abbiamo delineato la struttura generale del progetto, lavorando insieme mediante videochiamate e condivisione dello schermo di lavoro. Ci siamo poi suddivisi l'implementazione vera e propria del codice, versionandolo su GitHub, per poi concludere insieme con la stesura del ReadMe. 

La suddivisione del lavoro è stata la seguente:
* Giacometti ha lavorato maggiormente alle eccezioni, ai filtri e ai diagrammi uml delle sequenze.
* Pollonara si è occupato maggiormente delle statistiche, della struttura dei test, del javadoc e del diagramma dei casi d'uso.

Tutto il resto, ovvero i package model, database, controller, service e i diagrammi delle classi, sono stati elaborati insieme.

In ogni caso il lavoro individuale è stato costantemente sottoposto alla revisione dell'altro, apportando di volta in volta tutte le modifiche ritenute necessarie.


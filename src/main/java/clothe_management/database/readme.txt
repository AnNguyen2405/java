NOTE: UNTESTED

The Database package includes:
- 1 sub-package which contain custom DatabaseConnectionException.
- 1 dbConnection class for handling database connection.
- 1 genericDAO interface.
- 1 abstractGenericDAO abstract class - implements genericDAO. Every DAO extends this class.
- 1 singleKeyDAO interface, which contains method for the DAO whose database's primary key is atomic.
- 1 compositeKeyDAO interface, which contains method for the DAO whose database's primary key is composite (2).
- 7 DAO classes with atomic primary key.
- 2 DAO classes with composite primary key.
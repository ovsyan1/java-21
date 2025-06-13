::
:: create documenation exactly in javadocTest package
::

javadoc  javadocTest/JavaDocTest.java javadocTest/Person.java

::
:: create documenation in separate package
::

javadoc -d javadocTest/docs javadocTest/JavaDocTest.java javadocTest/Person.java
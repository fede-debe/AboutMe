package com.example.aboutme

/* I created this data class because instead of storing them as String resources, we make them proper data and then we'll bind
   that to my views. By using the Data class the data is directly available to the view (it makes the code simpler and sets
   things up to handle more complex cases. The "name" is currently set in a textView in the XML file from a string resource, I
   need to replace that with a reference to the data in our class. To let the layout know about the data we create a data block
   in the XML file(at the TOP inside the layout --> <data> block) 2nd add a variable block for our variable and then declare the
   variable in question inside of it. It needs a name (usually the same as the name of the data class), and a type (fully
   qualified name of the data class we just created. Now inside the XML file we can use this variable instead of the string resource.

   This will give me reference to the data, but I also need to create the actual data. */

data class MyName(var name: String = "", var nickname: String = "")
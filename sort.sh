#!/bin/sh

./compile.sh

if [ $? -eq 0 ]
then
echo "compilation successful, running program"


#java Sort 1 Files/names.txt SortedNames.txt
#java Sort 5 Files/names.txt SortedNames.txt
#java Sort 3000 Files/names.txt SortedNames.txt



#java Sort 1 Files/sowpods.txt SortedNames.txt
java Sort 5 Files/sowpods.txt SortedNames.txt
#java Sort 3000 Files/sowpods.txt SortedNames.txt



#java Sort 1 Files/linuxwords.txt SortedNames.txt
#java Sort 5 Files/linuxwords.txt SortedNames.txt
#java Sort 3000 Files/linuxwords.txt SortedNames.txt



else
echo "compilation error. work it out, dude!"
fi
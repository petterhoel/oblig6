#!/bin/sh

./compile.sh

if [ $? -eq 0 ]
then
echo "compilation successful, running program"
#java Sort 1 Files/names.txt SortedNames.txt
#java Sort 5 Files/names.txt SortedNames.txt
#java Sort 1000 Files/names.txt SortedNames.txt



#java Sort 1 Files/sowpods.txt SortedNames.txt
#java Sort 5 Files/sowpods.txt SortedNames.txt
#java Sort 1000 Files/sowpods.txt SortedNames.txt



#java Sort 1 Files/linuxwords.txt SortedNames.txt
java Sort 5 Files/linuxwords.txt SortedNames.txt
#java Sort 1000 Files/linuxwords.txt SortedNames.txt
#java Sort 19 Files/liten.txt SortedNames.txt

else
echo "compilation error. work it out, dude!"
fi
#!/bin/sh

./compile.sh

if [ $? -eq 0 ]
then
echo "compilation successful, running program"
java Sort 128 Files/linuxwords.txt SortedNames.txt
#java Sort 19 Files/liten.txt SortedNames.txt

else
echo "compilation error. work it out, dude!"
fi
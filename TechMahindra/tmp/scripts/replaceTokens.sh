#!/bin/bash

if [ $# != 3 ]
then
        echo "It must be 3 arguments only !"
        exit
fi

origHTMLFile=$1
propFile=$2
newHTMLFile=$3

## backup the output html file if it exists
if [ -f $newHTMLFile ]
then
   sed -i.bak "s/dummy1/dummy2/g"  $newHTMLFile
fi

## copy original HTML file to new HTML file
cp $1 $newHTMLFile

## puts values from properties into array
typeset -A propArr
while IFS='=' read -r key value
do
        propArr[$key]=${value}
done < $propFile


## replace values in new file by values from the property file

for index in "${!propArr[@]}"
do
   newValue=${propArr[$index]} 
   sed -i  "s/\[\[$index\]\]/$newValue/g" $newHTMLFile
done

echo "output file location: "$newHTMLFile


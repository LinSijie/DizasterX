# Created by Zeyu Chen

# Convert declaration date to a comparable string

import csv

with open('DisasterDeclarationsSummaries.csv', 'r') as csvOld:
    oldData = csv.reader(csvOld, delimiter=',')
    line = 0

    with open('newData.csv', 'w') as csvNew:
        newData = csv.writer(csvNew, delimiter=',')
        for row in oldData:
            if line == 0:
                row.append('dateNumber')
            else:
                declarationDate = row[6]
                date = declarationDate[0:4]+declarationDate[5:7]+declarationDate[8:10]
                row.append(date)
            
            line += 1
            newData.writerow(row)
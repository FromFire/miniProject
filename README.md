# Survey

## QRcode for Testing : https://android-lab-group-1.github.io/ with https://li.riino.site/download/question.json

## Questionnaire WebSite : http://xiaonan.ngrok2.xiaomiqiu.cn/server/

## Team member

Part abc:

- riino(Shih-Chi Chang)

- PXNPXN(Xiao-Nan Peng)

- blessiy(Jian Li)

Part bd: 

- FromFire(Jing-Wen Cheng)

- Moshu(Shu Mo)

## Status

### version 1.0

a.Web Server: done.(front end by Riino; back end and POST/GET procedure by PXN)

b.Main menu: DONE (By PXN ,Riino, Moshu)

c.QR Scanner: DONE (By PXN and Moshu)*(Abandon version by Riino in early version)*


d.Save answer： DONE (By fromfire))

e.Lock and save answers : 90% DONE (By Moshu )

 - Sync between local and server : TODO

## DB Structure

### TABLE Survey

| col integer INT | col surveyID TEXT | col surveyJsonString TEXT |
| --------------- | ----------------- | ------------------------- |
| (increasing)    |                   |                           |

### TABLE answer

| col id INT | col latitude DOUBLE | col timestamp DOUBLE | col sync INT | col IMEI char(20) | col answer TEXT |
| ---------- | ------------------- | -------------------- | ------------ | ----------------- | --------------- |
|            |                     |                      | 0            |                   |                 |

### Answer json format

```json
[
   {
      "question":"How well do the professors teach at this university?",
      "answers":[
         "Extremely well"
      ]
   },
   {
      "question":"Which of the following courses do you like?",
      "answers":[
         "Mathematics",
         "Computer"
      ]
   },
   {
      "question":"What do you suggest for the school?",
      "answers":[
         "idk"
      ]
   }
]
```



## Works cited

- zxing for QR scanning https://github.com/yuzhiqiang1993/zxing/tree/master/zxinglibrary/src/main/java/com/yzq/zxinglibrary

- SwipeMenuListView




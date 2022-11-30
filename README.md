# EXO 4 

#
``` sh
1-SELECT DISTINCT r1.id
FROM Redacteur r1, RedacteurThematique rt1, RedacteurLangue rl1 
WHERE (SELECT DISTINC r2.id FROM Redacteur r2,RedacteurThematique rt2, RedacteurLangue rl2 
WHERE
(r1.id <>r2.id and
rt1.id_redacteur==r1.id and
rl2.id_redacteur==r2.id and
rt1.id_redacteur==r1.id and
rt2.id_redacteur==r2.id and
(rt1.thematic==rt2.thematic && rl1.language==rl2.language)))
```
#
``` sh
2-SELECT C.Titre, CT.THematic FROM COMMANDE C , CommandeThematique CT
WHERE C.id ==and CD.id_commande
C.FinishedAT < dateX
```

#

``` sh
3-SELECT C.id, CRR.nbr_text FROM COMMANDE C , CommandeRedacteurRelation CRR
WHERE C.id == CRR.id_commande
CRR.nbr_text>6
``` 

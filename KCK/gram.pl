
zdanie(move(X,Y)) --> orz(X), okkier(Y).
zdanie(move(X,Y)) --> orz1(X),okkier1(goal(Y)).
zdanie(move(X,Y,Z)) --> orz1(X), okkier1(goal(Y)), ok_sposobu(Z).

orz(walk) --> [idz].
orz(turn) --> [skrec].
orz(drive) --> [jedz].
orz(head) --> [kieruj, sie].
orz(go) --> [pojdz].

okkier(dir(south)) --> [na, poludnie].
okkier(dir(east)) --> [na, zachod].
okkier(dir(north)) --> [na, polnoc].
okkier(dir(east)) --> [na, zachod].
okkier(dir(west)) --> [na, wschod].
okkier(dir(rt)) --> [w, prawo].
okkier(dir(straight)) --> [prosto].
okkier(dir(lt)) --> [w, lewo].
okkier(dir(up)) --> [w, gore].
okkier(dir(down)) --> [w, dol].
okkier(goal(X)) --> przyim(P), miejsce(P,X).

orz1(reach) --> [dojdz].
okkier1(goal(X)) --> przyim(P), miejsce(P,X).

przyim(dop) --> [do].

ok_sposobu(right) --> [z, prawej, strony].
ok_sposobu(left) --> [z, lewej, strony].
ok_sposobu(right) --> [z, prawej].
ok_sposobu(left) --> [z, lewej].

miejsce(mian, fountain) --> [fantanna].
miejsce(dop, fountain) --> [fontanny].
miejsce(mian, mosque) --> [meczet].
miejsce(dop, mosque) --> [meczetu].
miejsce(mian, church) --> [kosciol].
miejsce(narz, church) --> [kosciolem].
miejsce(mian, townhall) --> [ratusz].
miejsce(dop, townhall) --> [ratusza].
miejsce(mian, hospital) --> [szpital].
miejsce(dop, hospital) --> [szpitala].
miejsce(mian, baker) --> [piekarnie].
miejsce(dop, baker) --> [piekarni].
miejsce(mian, castle) --> [zamek].
miejsce(dop, castle) --> [zamku].
miejsce(mian, school) --> [szkola].
miejsce(dop, school) --> [szkoly].
miejsce(mian, park) --> [park].
miejsce(dop, park) --> [parku].
miejsce(mian, restaurant) --> [restauracja].
miejsce(dop, restaurant) --> [restauracji].



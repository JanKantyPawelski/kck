

zdanie(move(X,Y)) --> orz(X), okkier(Y).
zdanie(move(X,Y)) --> [dojdz], przyimek(X), miejsce(X,Y).
zdanie(move(X,Y)) --> [dojdz], przyimek(X), miejsce(X,Y), ok_sposobu.
zdanie(move(X)) --> [min], miejsce(mian,X), ok_sposobu.
zdanie(move(X)) --> [min], miejsce(mian,X).
zdanie(move(X)) --> [obejdz], miejsce(mian,X), ok_sposobu.
zdanie(move(X)) --> [objedz], miejsce(mian,X), ok_sposobu.
zdanie(move(X)) --> [przejdz, obok], miejsce(mian,X).
zdanie(move(X)) --> [przejdz], ok_sposobu, miejsce(dop,X).

orz(walk) --> [idz].
orz(turn) --> [skrec].
orz(drive) --> [jedz].
orz(head) --> [kieruj, sie].

okkier(dir(south)) --> [na, poludnie].
okkier(dir(east)) --> [na, zachod].
okkier(dir(north)) --> [na, polnoc].
okkier(dir(east)) --> [na, zachod].
okkier(dir(west)) --> [na, wschod].
okkier(dir(rt)) --> [w, prawo].
okkier(dir(straight)) --> [prosto].
okkier(dir(lt)) --> [w, lewo].
okkier(goal(X)) --> przyim(P), miejsce(P,X).

przyim(dop) --> [do].

ok_sposobu --> [z, prawej, strony].
ok_sposobu --> [z, lewej, strony].
ok_sposobu --> [z, prawej].
ok_sposobu --> [z, lewej].

miejsce(mian, monument) --> [pomnik].
miejsce(dop, monument) --> [pomnika].
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



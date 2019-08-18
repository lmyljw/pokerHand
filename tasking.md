# pokerHand
-------------------
test-1：单牌比大小
  input: "7C", "5D"
  then: player_1_win
-------------------
test-2：单牌平局
  input: "7C", "7D"
  then: peace
-------------------
test-3：单牌数字比字母
  input: "7C", "TD"
  then: player_2_win
-------------------
test-4：high card 比大小
  input: "3S 9H KC 5D 1S", "5S JH 9C 3H 1H"
  then: player_1_win
-------------------
test-5：pair 比 high card
  input: "3S 9H KC 5D 1S", "5S 5H 9C 3H 1H"
  then: player_2_win
-------------------
test-6：pair 相比较
  input: "7S 7C 8C 5D 1S", "5S 5H 9C 3H 1H"
  then: player_1_win
-------------------
test-7：high card 平局
  input: "3S 9H KC 5D 1S", "3C 9C KD 5H 1H"
  then: peace
-------------------
test-8：pair 的对子相同时比较
  input: "7S 7C 8C 5D 1S", "7D 7H 9C 3H 1H"
  then:  player_2_win
-------------------
test-9：pair 平局
  input: "7S 7C 8C 5D 1S", "7D 7H 8H 5H 1H"
  then:  peace
-------------------
test-10：two pairs 与 pair比较
  input: "7S 7C 8C 8D 1S", "7D 7H 8H 5H 1H"
  then:  player_1_win
-------------------
test-11：two pairs 两个对子相同时比较
  input: "7S 7C 8C 8D 1S", "7D 7H 8H 8S 3H"
  then:  player_2_win
-------------------
test-12：two pairs 平局
  input: "7S 7C 8C 8D 1S", "7D 7H 8H 8S 1H"
  then:  peace
-------------------
test-13：three of a kind 与 two pairs 比较
  input: "7S 7C 7H 8D 1S", "6D 6H 8H 8S 1H"
  then:  player_1_win
-------------------

def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()
    for i in range(0, len(completion)) :
        check = completion[i] == participant[i]
        if check is True :
            continue
        else :
            answer = participant[i];
            break
    b = answer == ''
    if (answer=='') is True :
        answer = participant[len(participant)-1]
    return answer

def solution2(partipant, completion) :
    answer = ''
    player = {}
    for name in participant :
        if (name in player) is False:
            player[name] = 1
        elif (name in player) is True : 
            player[name] = player[name] + 1
    for name in completion :
        player[name] -= 1
    for name in player.keys() :
        if (player[name] == 1) is True :
            answer= name
    
    return answer

participant = ["leo", "kiki", "eden"]
completion = ["eden", "kiki"]
player = solution(participant, completion)
# print(player)
palyer2  = solution2(participant,completion)
print(palyer2)
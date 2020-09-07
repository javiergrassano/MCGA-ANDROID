package com.example.tptiendamobile

import com.example.tptiendamobile.model.Team

fun mockTeam(): MutableList<Team> {

    val teamList: MutableList<Team> = ArrayList()

    teamList.add(Team("https://ci4.googleusercontent.com/proxy/0SygDKCTFCfgDbMQ4ggMW6pTG7mnR3GYU3VqwOkbM_pwEtdZPHfKBE-uvBSwh21C4r958Jf9aZ1UexZE3bIHUawrriH29Zb-dZlJQpAS=s0-d-e1-ft#https://avatars3.githubusercontent.com/u/64224981?s=120&v=4", "Javier Grassano", "Backend"))
    teamList.add(Team("https://ca.slack-edge.com/T636X490R-URAPKEKPT-6c48a543ecc4-512", "Julian de Titto", "Android"))
    teamList.add(Team("https://pps.whatsapp.net/v/t61.24694-24/57299491_435364077039637_2786225330220695552_n.jpg?oh=b0cc57e5904c8727206addc07d9f881c&oe=5F5AC588", "Hernan Cortes", "Front end"))
    teamList.add(Team("https://pps.whatsapp.net/v/t61.24694-24/76814210_598766590701224_2219921241861158383_n.jpg?oh=c9959bc6307c27f395f4f1df51697b63&oe=5F5A0372", "Juan Beltramino", "Front end"))
    teamList.add(Team("https://pps.whatsapp.net/v/t61.24694-24/64382691_2443235555761207_2978949227280859136_n.jpg?oh=4bd50936e37dfd5a99f34a940247bee9&oe=5F5A4EB4", "Juan Gonzales", "Front end"))
    teamList.add(Team("https://pps.whatsapp.net/v/t61.24694-24/97746972_174150997284758_2413528895520057072_n.jpg?oh=41455089e29dc26fa3b6d1302ffd5faf&oe=5F2C6B77", "Agustin Zalazar", "Front end"))
    teamList.add(Team("https://pps.whatsapp.net/v/t61.24694-24/64382691_2443235555761207_2978949227280859136_n.jpg?oh=999c2a63962cea3d3b58445bec4ac680&oe=5F3AAAB4", "Bruno Mahiques", "Front end"))

    return teamList
}
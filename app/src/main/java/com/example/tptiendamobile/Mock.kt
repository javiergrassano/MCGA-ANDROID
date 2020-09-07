package com.example.tptiendamobile

import com.example.tptiendamobile.model.Team

fun mockTeam(): MutableList<Team> {

    val teamList: MutableList<Team> = ArrayList()

    teamList.add(Team("https://ci4.googleusercontent.com/proxy/0SygDKCTFCfgDbMQ4ggMW6pTG7mnR3GYU3VqwOkbM_pwEtdZPHfKBE-uvBSwh21C4r958Jf9aZ1UexZE3bIHUawrriH29Zb-dZlJQpAS=s0-d-e1-ft#https://avatars3.githubusercontent.com/u/64224981?s=120&v=4", "Javier Grassano", "Backend"))
    teamList.add(Team("https://ca.slack-edge.com/T636X490R-URAPKEKPT-6c48a543ecc4-512", "Julian de Titto", "Android"))
    teamList.add(Team("https://pps.whatsapp.net/v/t61.24694-24/57299491_435364077039637_2786225330220695552_n.jpg?oh=b0cc57e5904c8727206addc07d9f881c&oe=5F5AC588", "Hernan Cortes", "Front end"))
    teamList.add(Team("https://media-exp1.licdn.com/dms/image/C4E03AQHDkIYtN9z41g/profile-displayphoto-shrink_200_200/0?e=1605139200&v=beta&t=yEmYM3Yak_6o4k5-JvcBJFo-1PPMJ7NTszgGZewUdeE", "Juan Beltramino", "Front end"))
    teamList.add(Team("https://pps.whatsapp.net/v/t61.24694-24/64382691_2443235555761207_2978949227280859136_n.jpg?oh=4bd50936e37dfd5a99f34a940247bee9&oe=5F5A4EB4", "Juan Gonzales", "Front end"))
    teamList.add(Team("https://instagram.faep8-2.fna.fbcdn.net/v/t51.2885-15/e35/p1080x1080/89965720_134255664777892_6617766245046632186_n.jpg?_nc_ht=instagram.faep8-2.fna.fbcdn.net&_nc_cat=104&_nc_ohc=qeJ-c8WqHA4AX9ZhL3C&oh=d324277b3e1f1dc33711c6b28f0ef116&oe=5F7F1C50", "Agustin Zalazar", "Front end"))
    teamList.add(Team("https://media-exp1.licdn.com/dms/image/C4E03AQGirc6qtt2QsQ/profile-displayphoto-shrink_200_200/0?e=1605139200&v=beta&t=wiFAT-EJ4MK_LiyhMblhjrrR_Wa_AECLW3SCA9ISFqA", "Bruno Mahiques", "Front end"))

    return teamList
}
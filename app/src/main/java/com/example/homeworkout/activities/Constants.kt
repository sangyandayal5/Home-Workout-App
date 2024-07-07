package com.example.homeworkout.activities

import com.example.homeworkout.R

object Constants {

    fun WarmupExeList() : ArrayList<ExeModel>{
        val ExeList  =  ArrayList<ExeModel>()

        val JJ = ExeModel(
            "Jumping Jack",
            R.drawable.abs_1_jumping_jacks_1,
            R.drawable.abs_1_jumping_jacks_2
        )
        ExeList.add(JJ)

        val CC = ExeModel(
            "Cat-Cow Pose",
            R.drawable.back_2_cat_cow_pose_1,
            R.drawable.back_2_cat_cow_pose_2
        )
        ExeList.add(CC)

        val PU = ExeModel(
            "Push Ups",
            R.drawable.chest_1_push_up_1,
            R.drawable.chest_1_push_up_2
        )
        ExeList.add(PU)

        val AS = ExeModel(
            "Arm Scissors",
            R.drawable.hands_4_arm_scissors_1,
            R.drawable.hands_4_arm_scissors_2
        )
        ExeList.add(AS)

        val SQ = ExeModel(
            "Squats",
            R.drawable.legs_1_squats_1,
            R.drawable.legs_1_squats_2
        )
        ExeList.add(SQ)

        return ExeList
    }

}
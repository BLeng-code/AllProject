import { Entity, Column, OneToMany, OneToOne, ManyToMany } from "typeorm";
import { Clothes } from "./Clothes";
import { Nose } from "./Nose";
import { Person } from "./Person";
import { Teacher } from "./Teacher";

@Entity()
export class Student extends Person {

    @ManyToMany(
        type => Teacher,
        teacher => teacher.students
    )
    teachers: Teacher[]
}

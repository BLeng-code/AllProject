import { Entity, Column, OneToMany, OneToOne, ManyToMany } from "typeorm";
import { Clothes } from "./Clothes";
import { Nose } from "./Nose";
import { Person } from "./Person";
import { Student } from "./Student";

@Entity()
export class Teacher extends Person {

    @ManyToMany(
        type => Student,
        student => student.teachers
    )
    students: Student[]
}

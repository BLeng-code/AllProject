import { Entity, Column, ManyToOne, OneToOne } from "typeorm";
import { Person } from "./Person";

@Entity()
export class Nose {
    @Column()
    name;

    @OneToOne(
        type => Person,
        person => person.nose
    )
    person;
}

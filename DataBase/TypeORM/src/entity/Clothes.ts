import { Entity, Column, ManyToOne } from "typeorm";
import { Person } from "./Person";

@Entity()
export class Clothes {
    @Column()
    name;

    @ManyToOne(
        type => Person,
        person => person.clothes
    )
    person;
}

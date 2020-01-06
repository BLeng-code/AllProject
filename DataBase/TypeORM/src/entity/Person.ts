import { Entity, Column, OneToMany, OneToOne } from "typeorm";
import { Clothes } from "./Clothes";
import { Nose } from "./Nose";

@Entity()
export class Person {
    @Column()
    name;

    @OneToOne(
        type => Nose,
        nose => nose.person
    )
    nose

    @OneToMany(
        type => Clothes,
        clothes => clothes.person
    )
    clothes: Clothes[]
}

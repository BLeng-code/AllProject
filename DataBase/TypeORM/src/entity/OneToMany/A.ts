import { Entity, PrimaryColumn, Column, OneToMany, PrimaryGeneratedColumn } from "typeorm";
import { B } from "./B";

@Entity()
export class A {
    @PrimaryGeneratedColumn()
    id;

    @Column()
    name:string;

    @OneToMany(
        type => B,
        b => b.a
    )
    bs: B[]
}

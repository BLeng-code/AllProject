import { Entity, PrimaryColumn, Column, ManyToOne, PrimaryGeneratedColumn } from "typeorm";
import { A } from "./A";

@Entity()
export class B {
    @PrimaryGeneratedColumn()
    id;

    @Column()
    name:string;

    @ManyToOne(
        type => A,
        a => a.bs
    )
    a: A;
}

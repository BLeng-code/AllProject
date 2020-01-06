import { Entity, PrimaryGeneratedColumn, Column, ManyToMany, Generated, JoinTable } from "typeorm";
import { F } from "./F";

@Entity()
export class G {
    @PrimaryGeneratedColumn()
    id;

    @Column()
    name: string

    @ManyToMany(
        type => F,
        f => f.gs
    )
    @JoinTable()
    fs: F[]
}

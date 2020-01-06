import { Entity, PrimaryGeneratedColumn, Column, ManyToMany, Generated, JoinTable } from "typeorm";
import { G } from "./G";

@Entity()
export class F {
    @PrimaryGeneratedColumn()
    id;

    @Column()
    name: string

    @ManyToMany(
        type => G,
        g => g.fs
    )
    @JoinTable()
    gs: G[]
}

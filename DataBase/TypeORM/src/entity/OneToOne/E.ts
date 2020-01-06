import { Entity, PrimaryGeneratedColumn, Column, OneToOne, ManyToOne, ManyToMany, JoinTable, JoinColumn } from "typeorm";
import { D } from "./D";
@Entity()
export class E {
    @PrimaryGeneratedColumn()
    id;

    @Column()
    name: string;

    @OneToOne(
        type => D
    )
    @JoinColumn()
    d: D;
}

import { Entity, PrimaryGeneratedColumn, Column, OneToOne, JoinColumn, OneToMany, ManyToMany, JoinTable } from "typeorm";
import { E } from "./E";
@Entity()
export class D {
    @PrimaryGeneratedColumn()
    id;

    @Column()
    name: string;

    @OneToOne(
        type => E
    )
    @JoinColumn()
    e;
}

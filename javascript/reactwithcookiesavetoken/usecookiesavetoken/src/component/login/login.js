import React from 'react'
import { useForm } from "react-hook-form";
import './login.css'



export default function Login(props) {

    const { register, handleSubmit, watch, formState: { errors } } = useForm();

    const onSubmit = data => console.log(data);

    console.log(watch("username") + " " + watch("password"));

    return (
        <div>
            <h1>Login</h1>

            <div className="contextForm">
                <form onSubmit={handleSubmit(onSubmit)} className="contextForm contextForm--form">

                    <div>
                        <label> Username </label>
                        <input className={errors.username ? "error-box":""} {...register("username", { required: true })} />
                        {errors.username && <span className="error-text">This field is required</span>}
                    </div>

                    <div>
                        <label> Password </label>
                        <input className={errors.password ? "error-box":""} {...register("password", { required: true })} />
                        {errors.password && <span className="error-text">This field is required</span>}
                    </div>

                    <input type="submit" />
                </form>
            </div>


        </div>
    )
}

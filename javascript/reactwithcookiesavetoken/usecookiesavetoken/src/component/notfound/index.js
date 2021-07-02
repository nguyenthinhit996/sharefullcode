import React from 'react'
import { useHistory } from 'react-router-dom';


export default function Index(props) {

    const history = useHistory();

    const goLogin = () => {
        history.push("/");
    }

    return (
        <>
            <h1> Not found path </h1>
            <button  onClick={goLogin} >Go to Login page</button>
        </>
    )
}



import React, { useEffect } from 'react'

export default function Tableviewindex({ listData }) {

    const rows = [
        createData('Cupcake           ', 305, 3.7, 67, 4.3),
        createData('Donut             ', 452, 25.0, 51, 4.9),
        createData('Eclair            ', 262, 16.0, 24, 6.0),
        createData('Frozen yoghurt    ', 159, 6.0, 24, 4.0),
        createData('Gingerbread       ', 356, 16.0, 49, 3.9),
        createData('Honeycomb         ', 408, 3.2, 87, 6.5),
        createData('Ice cream sandwich', 237, 9.0, 37, 4.3),
        createData('Jelly Bean        ', 375, 0.0, 94, 0.0),
        createData('KitKat            ', 518, 26.0, 65, 7.0),
        createData('Lollipop          ', 305, 0.2, 98, 0.0),
        createData('Marshmallow       ', 318, 0, 81, 2.0),
        createData('Nougat            ', 360, 19.0, 9, 37.0),
        createData('Oreo              ', 437, 18.0, 63, 4.0),
    ];


    // useEffect(() => {
    //     console.log("Tableviewindex");
    //     console.log(listData)
    // }, [listData])

    useEffect(() => {
        console.log("Before sort");
        console.log(rows)
        console.log("After sort");
        let rowsAfterSort = stableSort(rows, getComparator("desc", "calories"));
        console.log(rowsAfterSort);
        console.log("------------vvvvvvvvvvv--------------");
        console.log(rows)
    }, [])


    function descendingCompatator(a, b, index) { // giam dan
        if (a[index] > b[index]) { // khong sort 
            return -1;
        }
        if (a[index] < b[index]) { // trước bé sau thì swap nó
            return 1; // change 
        }
        return 0;
    }

    function getComparator(order, index) {
        return order === 'desc' ?
            (a, b) => descendingCompatator(a, b, index)
            : (a, b) => -descendingCompatator(a, b, index);
    }

    function stableSort(array, compatator) {
        const stabilizedThis = array.map((el, index) => [el, index]);
        console.log(stabilizedThis);
        stabilizedThis.sort((a, b) => {
            const order = compatator(a[0], b[0]);
            if (order !== 0) return order;
            return a[1] - b[1];
        });
        return stabilizedThis.map((el) => el[0]);
    }

    function createData(name, calories, fat, carbs, protein) {
        return { name, calories, fat, carbs, protein };
    }

    

    return (
        <>
             
        </>
    )
}

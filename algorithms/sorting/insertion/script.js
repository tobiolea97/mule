function insertionSort(arr)  
{
    let length = arr.length;
    let i, key, j;  
    for (i = 1; i < length; i++) 
    {  
        key = arr[i];  
        j = i - 1;
        while (j >= 0 && arr[j] > key) 
        {  
            arr[j + 1] = arr[j];  
            j = j - 1;  
        }  
        arr[j + 1] = key;  
    }
    return arr;
}

console.log(insertionSort([12, 11, 13, 5, 6 ]));
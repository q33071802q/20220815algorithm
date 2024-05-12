class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

function createLinkedList(arr) {
    if (arr.length === 0) {
        return null;
    }

    const head = new Node(arr[0]);
    let current = head;

    for (let i = 0; i < arr.length; i++) {
        current.next = new Node(arr[i])
        current = current.next;
    }

    return head;
}

function mergeLinkedLists(lists){
    if (lists.length === 0){
        return null;
    }

    let mergedList = lists[0];

    for (let i = 0; i < lists.length; i++) {
        mergedList = mergeTwoLists(mergedList,lists[i]);
    }
    return mergedList;
}

function mergeTwoLists(list1,list2){
    const result = new Node(null)
    let current = result;

    while (list1 || list2){
        if (list1 && (!list2 || list1.value<=list2.value)){
            current.next = new Node(list1.value)
            list1 = list1.next;
        }else if (list2){
            current.next = new Node(list2.value)
            list2 = list2.next;
        }
        current = current.next
    }
}

function printLinkedList(head){
    const values = [];
    let current = head;
    while (current){
        values.push(current.value)
        current = current.next;
    }
    console.log(values);
}

const arr1 = [1,4,5]
const arr2 = [1,3,4];
const arr3 = [2,6];

const list1 = createLinkedList(arr1)
const list2 = createLinkedList(arr2)
const list3 = createLinkedList(arr3)

const combinedList = mergeLinkedLists([list1,list2,list3])
printLinkedList(combinedList)


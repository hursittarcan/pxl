function byTagName(node, string) {
    let list = node.getElementsByTagName(string);
    return Array.from(list);
}

console.log(byTagName(document.body, "h1"));
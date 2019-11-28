function show(type)
{
    // noinspection JSUndeclaredVariable,JSUndeclaredVariable
    count = 0;
    for (var key in methods) {
        // noinspection JSUnfilteredForInLoop
        var row = document.getElementById(key);
        // noinspection JSUnfilteredForInLoop,JSUnfilteredForInLoop
        if ((methods[key] &  type) !== 0) {
            row.style.display = '';
            row.className = (count++ % 2) ? rowColor : altColor;
        }
        else
            row.style.display = 'none';
    }
    updateTabs(type);
}

function updateTabs(type)
{
    for (var value in tabs) {
        // noinspection JSUnfilteredForInLoop
        var sNode = document.getElementById(tabs[value][0]);
        var spanNode = sNode.firstChild;
        if (value === type) {
            sNode.className = activeTableTab;
            // noinspection JSUnfilteredForInLoop
            spanNode.innerHTML = tabs[value][1];
        }
        else {
            sNode.className = tableTab;
            // noinspection JSUnfilteredForInLoop,JSUnfilteredForInLoop
            spanNode.innerHTML = "<a href=\"javascript:show("+ value + ");\">" + tabs[value][1] + "</a>";
        }
    }
}

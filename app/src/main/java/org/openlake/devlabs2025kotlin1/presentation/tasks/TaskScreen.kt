package org.openlake.devlabs2025kotlin1.presentation.tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import org.openlake.devlabs2025kotlin1.presentation.components.Task
import org.openlake.devlabs2025kotlin1.presentation.components.TaskItem
import org.openlake.devlabs2025kotlin1.presentation.components.Priority

@Composable
fun TaskScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("To Do", "In Progress", "Done")

    val tasks = remember { sampleTasks }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = null)
                }
            }

            IconButton(onClick = { }) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        val filtered = tasks.filter { it.status == tabs[selectedTab] }

        LazyColumn {
            items(filtered) { task ->
                TaskItem(task = task)
                HorizontalDivider()
            }
        }
    }
}

val sampleTasks = listOf(

    Task(
        id = 1,
        title = "Taskify",
        description = "This is a new Task that is updated",
        priority = Priority.MEDIUM,
        status = "To Do"
    )
)

@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    TaskScreen()
}
